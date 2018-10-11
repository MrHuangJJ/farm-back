package com.lanzan.controller;

import com.lanzan.entity.Cars;
import com.lanzan.entity.RealTime;
import com.lanzan.service.CarsService;
import com.lanzan.service.RealTimeService;
import com.lanzan.service.JudgeWhetherExistService;
import com.lanzan.service.AgriculturalMachineryService;
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

import java.util.*;

@Component
public class CarsController{

    private static CloseableHttpClient closeableHttpClient;

    @Autowired
    private CarsService carsService;
    @Autowired
    private RealTimeService realTimeService;
    @Autowired
    private JudgeWhetherExistService judgeWhetherExistService;
    @Autowired
    private AgriculturalMachineryService agriculturalMachineryService;

    @Scheduled(cron = "0/2 * * * * ?")//每隔2秒执行一次//@Scheduled(cron = "0 0 * * * ?")//每隔1小时执行一次
    public void test001(){
        // 创建HttpClientBuilder
        if (closeableHttpClient == null) {
            //登录
            HttpPost httpPost = new HttpPost("http://www.tbitgps.com/accountAction!login.do");
            closeableHttpClient = HttpClientBuilder.create().build();
            httpPost.setConfig(
                    RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build()// 设置请求和传输超时时间
            );
            //登录的相关参数以及登录后操作参数
            List<NameValuePair> loginParams = new ArrayList<NameValuePair>();
            loginParams.add(new BasicNameValuePair("type","2"));
            loginParams.add(new BasicNameValuePair("name", "31017"));
            loginParams.add(new BasicNameValuePair("password", "sh123456"));
            try {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(loginParams, "UTF-8");
                //登录
                httpPost.setEntity(entity);
                CloseableHttpResponse loginResponse = closeableHttpClient.execute(httpPost);
                System.out.println("登录：" + EntityUtils.toString(loginResponse.getEntity(), "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 获取盒子信息
        try{
            String queryUrl = "http://www.tbitgps.com/accountAction!getData.do";
            List<NameValuePair> queryParams = new ArrayList<NameValuePair>();
            Map<String,List<NameValuePair>> queryMap = new HashMap<String,List<NameValuePair>>();
            queryMap.put(queryUrl, queryParams);
            //登录后其他操作
            for(Map.Entry<String,List<NameValuePair>> entry : queryMap.entrySet()){
                String url = entry.getKey();
                List<NameValuePair> params = queryMap.get(url);
                HttpPost httpPost = new HttpPost(url);
                if(null != params){
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
                    httpPost.setEntity(entity);
                }
                CloseableHttpResponse operationResponse = closeableHttpClient.execute(httpPost);
                Integer statusCode = operationResponse.getStatusLine().getStatusCode();
                //接收数据
                String str = EntityUtils.toString(operationResponse.getEntity(), "UTF-8");
                JSONObject jsonObject = JSONObject.fromObject(str);
                JSONObject jsonResult=jsonObject.getJSONObject("result");
                if (jsonResult!=null && jsonResult.size()>0){
                    JSONArray jsonArrayCars = jsonObject.getJSONObject("result").getJSONArray("cars");
                    if (jsonArrayCars!=null && jsonArrayCars.size()>0){
                        JSONObject row = null;
                            for (int k = 0; k < jsonArrayCars.size(); k++) {
                                Cars cars=new Cars();
                                row = jsonArrayCars.getJSONObject(k);
                                cars.setCarIcon((Integer) row.get("carIcon"));
                                cars.setCarId((Integer) row.get("carId"));
                                cars.setCarNO((String) row.get("carNO"));
                                cars.setMachineNO((String) row.get("machineNO"));
                                cars.setServiceStatus((Integer) row.get("serviceStatus"));
                                cars.setServiceTime((String) row.get("serviceTime"));
                                cars.setTeamId((Integer) row.get("teamId"));
                                int car=judgeWhetherExistService.getCarIdYesNo(row.get("carId").toString());
                                if (car < 1){
                                    //盒子数据不存在 添加
                                    carsService.addCars(cars);
                                }
                            }
                    }
                }
                if(statusCode == 302){
                    String redirectUrl = operationResponse.getLastHeader("Location").getValue();
                    httpPost = new HttpPost(redirectUrl);
                    CloseableHttpResponse redirectResponse = closeableHttpClient.execute(httpPost);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // 获取车辆终端码
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

        //获取车辆信息位置
        try {
            String catUrl = "http://www.tbitgps.com/carAction!getPositionByID.do";
            List<NameValuePair> catParams = new ArrayList<NameValuePair>();
            catParams.add(new BasicNameValuePair("carId",str+","));

            Map<String,List<NameValuePair>> urlAndNamePairList = new HashMap<String,List<NameValuePair>>();
            urlAndNamePairList.put(catUrl,catParams);

            //登录后其他操作
            for(Map.Entry<String,List<NameValuePair>> entry : urlAndNamePairList.entrySet()){
                String url = entry.getKey();
                List<NameValuePair> params = urlAndNamePairList.get(url);
                HttpPost httpPost = new HttpPost(url);
                if(null!=params){
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
                    httpPost.setEntity(entity);
                }
                CloseableHttpResponse operationResponse = closeableHttpClient.execute(httpPost);
                Integer statusCode = operationResponse.getStatusLine().getStatusCode();

                //接收数据
                String catStr = EntityUtils.toString(operationResponse.getEntity(), "UTF-8");
                JSONObject jsonObject = JSONObject.fromObject(catStr);
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
                            if (row.get("online").equals(true)){
                                //在线添加数据
                                realTimeService.addRealTime(realTime);
                            }
                        }
                }
                if(statusCode == 302){
                    String redirectUrl = operationResponse.getLastHeader("Location").getValue();
                    httpPost = new HttpPost(redirectUrl);
                    CloseableHttpResponse redirectResponse = closeableHttpClient.execute(httpPost);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // 获取在线状态
        try {
            // 根据车辆编号获取在线状态接口
            String carStateUrl="http://www.tbitgps.com/carAction!getOnLineByCarID.do";
            List<NameValuePair> carStateParams = new ArrayList<NameValuePair>();
            carStateParams.add(new BasicNameValuePair("carId",str+","));

            Map<String,List<NameValuePair>> stateMap = new HashMap<String,List<NameValuePair>>();
            stateMap.put(carStateUrl,carStateParams);
            //登录后其他操作
            for(Map.Entry<String,List<NameValuePair>> entry : stateMap.entrySet()){
                String url = entry.getKey();
                List<NameValuePair> params = stateMap.get(url);
                HttpPost httpPost = new HttpPost(url);
                if(null!=params){
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
                    httpPost.setEntity(entity);
                }
                CloseableHttpResponse operationResponse = closeableHttpClient.execute(httpPost);

                Integer statusCode = operationResponse.getStatusLine().getStatusCode();
                String catStateStr = EntityUtils.toString(operationResponse.getEntity(), "UTF-8");
                JSONObject jsonObject = JSONObject.fromObject(catStateStr);
                JSONArray json=jsonObject.getJSONArray("result");
                if (json!=null && json.size()>0){
                    JSONObject row = null;
                        for (int j = 0; j < json.size(); j++) {
                            row = json.getJSONObject(j);
                            if (row.get("online").equals(true)){
                                //车辆在线
                                agriculturalMachineryService.updateAmState("在线",row.get("carId").toString());
                            }else {
                                //不在线
                                agriculturalMachineryService.updateAmState("离线",row.get("carId").toString());
                            }
                        }
                }
                if(statusCode == 302){
                    String redirectUrl = operationResponse.getLastHeader("Location").getValue();
                    httpPost = new HttpPost(redirectUrl);
                    CloseableHttpResponse redirectResponse = closeableHttpClient.execute(httpPost);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
