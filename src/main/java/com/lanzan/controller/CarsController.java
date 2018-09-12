package com.lanzan.controller;

import com.lanzan.entity.Cars;
import com.lanzan.entity.RealTime;
import com.lanzan.service.CarsService;
import com.lanzan.service.RealTimeService;
import com.lanzan.service.JudgeWhetherExistService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CarsController{

    @Autowired
    private CarsService carsService;
    @Autowired
    private RealTimeService realTimeService;
    @Autowired
    private JudgeWhetherExistService judgeWhetherExistService;

    /**
     * 如果用的是同一个HttpClient且没去手动连接放掉client.getConnectionManager().shutdown();
     *
     * 都不用去设置cookie的ClientPNames.COOKIE_POLICY。httpclient都是会保留cookie的
     * @param loginUrl
     * @param loginNameValuePair
     * @param urlAndNamePairList
     * @return
     */
    public static Map<String,String> doPostWithOneHttpclient(String loginUrl,List<NameValuePair> loginNameValuePair, Map<String,List<NameValuePair>> urlAndNamePairList) {
        //返回每个URL对应的响应信息
        Map<String,String> map = new HashMap<String,String>();
        String retStr = "";//每次响应信息
        int statusCode = 0 ;//每次响应代码

        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = null;
        closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(loginUrl);
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
        httpPost.setConfig(requestConfig);
        UrlEncodedFormEntity entity = null;
        try {
            if(null!=loginNameValuePair){
                entity = new UrlEncodedFormEntity(loginNameValuePair, "UTF-8");
                httpPost.setEntity(entity);
            }
            //登录
            CloseableHttpResponse loginResponse = closeableHttpClient.execute(httpPost);
            statusCode = loginResponse.getStatusLine().getStatusCode();
            retStr = EntityUtils.toString(loginResponse.getEntity(), "UTF-8");
            map.put(loginUrl, retStr);

            //登录后其他操作
            for(Map.Entry<String,List<NameValuePair>> entry : urlAndNamePairList.entrySet()){
                String url = entry.getKey();
                List<NameValuePair> params = urlAndNamePairList.get(url);
                httpPost = new HttpPost(url);
                if(null!=params){
                    entity = new UrlEncodedFormEntity(params, "UTF-8");
                    httpPost.setEntity(entity);
                }
                CloseableHttpResponse operationResponse = closeableHttpClient.execute(httpPost);
                statusCode = operationResponse.getStatusLine().getStatusCode();
                retStr = EntityUtils.toString(operationResponse.getEntity(), "UTF-8");
                map.put(url, retStr);

                if(statusCode == 302){
                    String redirectUrl = operationResponse.getLastHeader("Location").getValue();
                    httpPost = new HttpPost(redirectUrl);
                    CloseableHttpResponse redirectResponse = closeableHttpClient.execute(httpPost);
                    statusCode = redirectResponse.getStatusLine().getStatusCode();
                    retStr = EntityUtils.toString(redirectResponse.getEntity(), "UTF-8");
                    map.put(redirectUrl, retStr);
                }
            }
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    // 添加Cars
    @Scheduled(cron = "0 0 * * * ?")//每隔1小时执行一次
    public void addCars() {
        //登录的地址以及登录操作参数
        String loginUrl = "http://www.tbitgps.com/accountAction!login.do";

        List<NameValuePair> loginParams = new ArrayList<NameValuePair>();
        loginParams.add(new BasicNameValuePair("type","2"));
        loginParams.add(new BasicNameValuePair("name", "31017"));
        loginParams.add(new BasicNameValuePair("password", "sh123456"));

        //登录后操作地址以及登录后操作参数
        String queryUrl = "http://www.tbitgps.com/accountAction!getData.do";
        List<NameValuePair> queryParams = new ArrayList<NameValuePair>();

        Map<String,List<NameValuePair>> map = new HashMap<String,List<NameValuePair>>();
        map.put(queryUrl, queryParams);
        Map<String,String> returnMap = doPostWithOneHttpclient(loginUrl, loginParams, map);

        //接收jsonArray数据
        JSONArray jsonArray = JSONArray.fromObject(returnMap.values());
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            JSONObject jsonresult=jsonObject.getJSONObject("result");
            if (jsonresult!=null && jsonresult.size()>0){
                JSONArray jsonArraycars = jsonObject.getJSONObject("result").getJSONArray("cars");
                if (jsonArraycars!=null && jsonArraycars.size()>0){
                    JSONObject row = null;
                    for (int k = 0; k < jsonArraycars.size(); k++) {
                        Cars cars=new Cars();
                        row = jsonArraycars.getJSONObject(k);
                        cars.setCarIcon((Integer) row.get("carIcon"));
                        cars.setCarId((Integer) row.get("carId"));
                        cars.setCarNO((String) row.get("carNO"));
                        cars.setMachineNO((String) row.get("machineNO"));
                        cars.setServiceStatus((Integer) row.get("serviceStatus"));
                        cars.setServiceTime((String) row.get("serviceTime"));
                        cars.setTeamId((Integer) row.get("teamId"));
                        int car=judgeWhetherExistService.getCarIdYesNo((String) row.get("carId"));
                        if (car>0){
                            //存在 不做操作
                            System.out.println("car==="+car);
                        }else {
                            //不存在 添加
                            carsService.addCars(cars);
                        }
                    }
                }
            }

        }
    }



    /**
     * 实时位置数据添加
     *
     */
    @Scheduled(cron = "0/5 * * * * ?")//每隔5秒执行一次
    public void addRealTime() {
        //登录的地址以及登录操作参数
        String loginUrl = "http://www.tbitgps.com/accountAction!login.do";
        //登录的相关参数以及登录后操作参数
        List<NameValuePair> loginParams = new ArrayList<NameValuePair>();
        loginParams.add(new BasicNameValuePair("type","2"));
        loginParams.add(new BasicNameValuePair("name", "31017"));
        loginParams.add(new BasicNameValuePair("password", "sh123456"));
        //获取车辆信息位置
        String catUrl = "http://www.tbitgps.com/carAction!getPositionByID.do";
        List<NameValuePair> catParams = new ArrayList<NameValuePair>();
        StringBuilder str=new StringBuilder();
        List<Cars> cars=carsService.listCarId();
        for (int i = 0; i < cars.size(); i++) {
            if(i==cars.size()-1){ //当循环到最后一个的时候 就不添加逗号
                str.append(cars.get(i));
            }else {
                str.append(cars.get(i));
                str.append(",");
            }
        }
        System.out.println(str);
        catParams.add(new BasicNameValuePair("carId",str+","));

        Map<String,List<NameValuePair>> map = new HashMap<String,List<NameValuePair>>();
        map.put(catUrl,catParams);
        Map<String,String> returnMap = doPostWithOneHttpclient(loginUrl, loginParams, map);

        //接收jsonArray数据
        JSONArray jsonArray = JSONArray.fromObject(returnMap.values());
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            JSONArray json=jsonObject.getJSONArray("result");
            if (json!=null && json.size()>0){
                JSONObject row = null;
                for (int j = 0; j < json.size(); j++) {
                    RealTime realTime = new RealTime();
                    row = json.getJSONObject(j);
                    realTime.setAcode((String) row.get("acode"));
                    realTime.setCarId((Integer) row.get("carId"));
                    realTime.setDirection((Integer) row.get("direction"));
                    realTime.setGpstime((String) row.get("gpstime"));
                    realTime.setLa((Double) row.get("la"));
                    realTime.setLat((Double) row.get("lat"));
                    realTime.setLng((Double) row.get("lng"));
                    realTime.setLo((Double) row.get("lo"));
                    realTime.setMileage((Integer) row.get("mileage"));
                    realTime.setOnline((Boolean) row.get("online"));
                    realTime.setPointed((Integer) row.get("pointed"));
                    realTime.setScode((String) row.get("scode"));
                    realTime.setSpeed((Integer) row.get("speed"));
                    realTime.setStopTime((Integer) row.get("stopTime"));
                    realTime.setStrGGPV((String) row.get("strGGPV"));
                    System.out.println("设备设备："+row.get("online"));
                    if (row.get("online").equals(true)){
                        //在线添加数据
                        realTimeService.addRealTime(realTime);
                    }else {
                        //不在线不做操作
                        System.out.println("设备不在线");
                    }
                }
            }

        }

    }

}
