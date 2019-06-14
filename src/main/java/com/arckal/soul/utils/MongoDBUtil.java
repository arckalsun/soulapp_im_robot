//package com.arckal.soul.utils;
//
///**
// * mongdb工具类
//
// * @Author: arckal
// * @Date: 2019/5/31 17:36
// * @Version 1.0
// */
//
//
//import com.mongodb.*;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoCursor;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class MongoDBUtil {
//    //数据库
//    private MongoDatabase database = null;
//    private DB get_db_credit = null;
//    private  MongoCollection<Document> collection = null;
//    private DBCollection dbcollection = null;
//    private DBCursor dbCursor = null;
//    private MongoCursor<Document> cursor = null;
//    private FindIterable<Document> findIterable = null;
//    //客户端实例
//    private MongoClient mongoClient = null;
//
//
//
//    /**
//     * 构造函数
//     *
//     */
//    public MongoDBUtil(){
//        this.mongoClient =getMongoClient();
//    }
//
//    public void getMongoDatabase(String dataBsae) throws Exception{
//        database = this.mongoClient.getDatabase(dataBsae);
//    }
//
//    public void getDB(String dataBsae){
//        get_db_credit = this.mongoClient.getDB(dataBsae);
//    }
//
//    public  DBCollection  getDBCollection(String dataBsae,String tableName){
//        getDB(dataBsae);
//        this.dbcollection =  get_db_credit.getCollection(tableName);
//        return this.dbcollection ;
//    }
//
//    public MongoCollection getMongoCollection(String dataBsae,String tableName) throws Exception{
//        getMongoDatabase(dataBsae);
//        this.collection = database.getCollection(tableName);
//        return this.collection;
//    }
//
//    public  MongoCursor<Document> getMongoCursor(String dataBsae,String tableName,BasicDBObject searchQueryCity,BasicDBObject sort) throws Exception{
//        getMongoCollection(dataBsae, tableName);
//        if(sort !=null){
//            this.cursor =  this.collection.find(searchQueryCity).sort(sort).iterator();
//        }else{
//            this.cursor =  this.collection.find(searchQueryCity).iterator();
//        }
//
//        return cursor;
//    }
//
//    public  DBCursor getDBCursor(String dataBsae,String tableName,BasicDBObject searchQueryCity){
//        getDBCollection(dataBsae,tableName);
//        dbCursor =  this.dbcollection.find(searchQueryCity);
//        return dbCursor;
//    }
//
//    public FindIterable<Document> getFindIterable(String dataBsae,String tableName,BasicDBObject searchQueryCity,int page,int size, BasicDBObject sort) throws Exception{
//        getMongoCollection(dataBsae, tableName);
//        return findIterable = collection.find(searchQueryCity).skip(page).sort(sort)
//                .limit(size);
//    }
//
//    public void closeDBCursor(){
//        dbCursor.close();
//        mongoClient.close();
//    }
//
//    public void closeMongoCursor(){
//        cursor.close();
//        mongoClient.close();
//    }
//
//    public void closeMongoClient(){
//        mongoClient.close();
//    }
//    /**
//     * 获取MONGODB客户端实例
//     *
//     * @return
//     * @throws Exception
//     */
//    private MongoClient getMongoClient() {
//        try {
//            String sIp = "localhost";
//            int iPort = 27017;
////            return new MongoClient(sIp, iPort);
//            // ===================================================//
//            List<ServerAddress> serverList = new ArrayList<ServerAddress>();
//            serverList.add(new ServerAddress(sIp, iPort));
//            // ===================================================//
//            List<MongoCredential> mcList = new ArrayList<MongoCredential>();
////            mcList.add(MongoCredential.createCredential(sUser, sDbNm,
////                    sPasword.toCharArray()));
//            // ===================================================//
//            MongoClientOptions.Builder builder = MongoClientOptions.builder();
//            // 与目标数据库能够建立的最大connection数量为50
//            builder.connectionsPerHost(50);
//            // 如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
//            builder.threadsAllowedToBlockForConnectionMultiplier(50);
//            // 一个线程访问数据库的时候，在成功获取到一个可用数据库连接之前的最长等待时间为2分钟
//            // 这里比较危险，如果超过maxWaitTime都没有获取到这个连接的话，该线程就会抛出Exception
//            // 故这里设置的maxWaitTime应该足够大，以免由于排队线程过多造成的数据库访问失败
//            builder.maxWaitTime(1000 * 60 * 2);
//            // 与数据库建立连接的timeout设置为1分钟
//            builder.connectTimeout(1000 * 60 * 1);
//            // ===================================================//
//            builder.codecRegistry(com.mongodb.MongoClient.getDefaultCodecRegistry());
//            MongoClientOptions mco = builder.build();
//            return new MongoClient(serverList, mcList, mco);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//}
//
//
////mongdb取数据，（包含分页）
//
////
////        PageView pageView = new PageView();
////        CommonUtil commonUtil = new CommonUtil();
////        String cityCode = this.getPara("selCity");// 当前城市
////        if (StringUtils.isNullOrEmpty(cityCode)) {
////        cityCode = iSelCity + "";
////        }
////        // 分页信息开始
////        String page = StringUtils.isNullOrEmpty(this.getPara("sPage"))
////        ? "1"
////        : this.getPara("sPage");
////        Integer curPage = Integer.parseInt(page);
////        pageView.setCurrentPage(curPage);
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        logger.debug("START...");
////        Date date = new Date();// 取时间
////        Calendar calendar = new GregorianCalendar();
////        calendar.setTime(date);
////        calendar.add(calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动
////        date = calendar.getTime();
////        // App用户基本信息
////        // mongoDB获取连接
////        MongoDBUtil mongoClient = new MongoDBUtil();
////        // 获取数据库
////        String mdb = DESUtil.decryptMode(
////        SysPropertyJdbc.getProperty("jdbc.deskey").substring(4, 28),
////        MongoDBProperty.getProperty("mdb"));
////
////        BasicDBObject condition = new BasicDBObject();
////        condition.put("statDate", new BasicDBObject("$gte",matter2.parse(datestart)).append("$lte", matter2.parse(dateend))); //日期查询条件  查询时间范围 gt大于， lt小于 gte、ge大于等于   lte、le 小于等于
////        if (!"999".equals(cityCode)) {
////        condition.put("cityCode", cityCode);
////        }
////        BasicDBObject sort = new BasicDBObject();
////        // 1,表示正序； －1,表示倒序
////        sort.put("cityCode", 1);// 按照活跃度排名
////        MongoCursor<Document> cursor1 = mongoClient.getMongoCursor(mdb, "app_user_stat", condition,sort);
////        Integer i = 0;
////        try{
////        while (cursor1.hasNext()) {
////        cursor1.next();
////        i++;
////        }
////        } finally {
////        cursor1.close();
////        }
////        pageView.setTotal(i);
////        MongoCursor<Document> cursor = mongoClient.getFindIterable(mdb, "app_user_stat", condition, (curPage - 1) * pageView.getPageSize(), pageView.getPageSize(), sort).iterator();
////        List<Record> appDetail = new ArrayList<Record>();
////        try{
////        while (cursor.hasNext()) {
////        Iterator<Entry<String, Object>> iter = cursor.next().entrySet()
////        .iterator();
////        Record record = new Record();
////        while (iter.hasNext()) {
////        Entry eTmp = (Entry) iter.next();
////        Map colums = record.getColumns();
////        String sKeyTmp = eTmp.getKey().toString();
////        String sKeyValue = "";
////        if (eTmp.getValue() == null) {
////        sKeyValue = "0";
////        } else {
////        sKeyValue = eTmp.getValue().toString();
////        }
////        switch (sKeyTmp) {
////        case "statDate" :
////        if ("0".equals(sKeyValue)) {
////        colums.put("DATE", dateFormat.format(new Date()));
////        } else {
////        System.out.println("test" + sKeyValue);
////        colums.put("DATE",
////        dateFormat.format(eTmp.getValue()));
////        }
////        break;
////        case "cityName" :
////        // String cityName = TCity.dao
////        // .getCityInfoByCityCd(sKeyValue).get(0)
////        // .getStr("city_name");
////        colums.put("CITY", sKeyValue);
////        break;
////        case "userSum" :
////        colums.put("TOTALUSER", sKeyValue);
////        break;
////        case "newUserSum" :
////        colums.put("NEWADD", sKeyValue);
////        break;
////        case "activeUserDay" :
////        colums.put("ACTIVEDAY", sKeyValue);
////        break;
////        case "activeUserWeek" :
////        colums.put("ACTIVEWEEK", sKeyValue);
////        break;
////        case "activeUserMonth" :
////        colums.put("ACTIVEMONTH", sKeyValue);
////        break;
////        case "openTimes" :
////        colums.put("APPOPEN", sKeyValue);
////        break;
////        case "avgTimeDay" :
////        colums.put("AVGDAY", sKeyValue);
////        break;
////        case "avgTimeWeek" :
////        colums.put("AVGWEEK", sKeyValue);
////        break;
////        }
////        }
////        appDetail.add(record);
////        }
////        } finally {
////        cursor.close();
////        mongoClient.closeMongoClient();
////        }