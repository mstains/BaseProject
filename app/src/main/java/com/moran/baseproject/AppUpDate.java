package com.moran.baseproject;

public class AppUpDate {

    private String fh;
    private EhBean eh;
    private BodyBean body;

    public String getFh() {
        return fh;
    }

    public void setFh(String fh) {
        this.fh = fh;
    }

    public EhBean getEh() {
        return eh;
    }

    public void setEh(EhBean eh) {
        this.eh = eh;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class EhBean {
        /**
         * clientOsver : 11
         * appVersion : 1.6.48
         * ReqTime : 1542074332081
         * isShare : 1
         * realipzjs : 122.225.201.180
         * ZJS_CUSTOMER_CHECK_COOKIE : ec0c11c5b5be471590498aae36e939f3
         * ZJS_AUTH_CODE_ID : 33ec0740cfd244128641e2a7a707484b
         * userid : 18758270411
         * platform : ios
         */

        private String clientOsver;
        private String appVersion;
        private String ReqTime;
        private String isShare;
        private String realipzjs;
        private String ZJS_CUSTOMER_CHECK_COOKIE;
        private String ZJS_AUTH_CODE_ID;
        private String userid;
        private String platform;

        public String getClientOsver() {
            return clientOsver;
        }

        public void setClientOsver(String clientOsver) {
            this.clientOsver = clientOsver;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public String getReqTime() {
            return ReqTime;
        }

        public void setReqTime(String ReqTime) {
            this.ReqTime = ReqTime;
        }

        public String getIsShare() {
            return isShare;
        }

        public void setIsShare(String isShare) {
            this.isShare = isShare;
        }

        public String getRealipzjs() {
            return realipzjs;
        }

        public void setRealipzjs(String realipzjs) {
            this.realipzjs = realipzjs;
        }

        public String getZJS_CUSTOMER_CHECK_COOKIE() {
            return ZJS_CUSTOMER_CHECK_COOKIE;
        }

        public void setZJS_CUSTOMER_CHECK_COOKIE(String ZJS_CUSTOMER_CHECK_COOKIE) {
            this.ZJS_CUSTOMER_CHECK_COOKIE = ZJS_CUSTOMER_CHECK_COOKIE;
        }

        public String getZJS_AUTH_CODE_ID() {
            return ZJS_AUTH_CODE_ID;
        }

        public void setZJS_AUTH_CODE_ID(String ZJS_AUTH_CODE_ID) {
            this.ZJS_AUTH_CODE_ID = ZJS_AUTH_CODE_ID;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }
    }

    public static class BodyBean {
        /**
         * contents : 1.测试升级缺陷
         2.换行测试换缺陷
         3.换行测试换行测试换行
         4.换行测试换行测试换行；

         * upType : 0
         * upurl : http://10.18.13.141:8181/ife/static/zjfae_1.6.50-104.apk
         * versionid : 1.6.50
         * picName : 升级图片.jpg
         * picAddress : http://10.18.13.141:8181/ife/static/升级图片.jpg
         * returnCode : 9999
         * returnMsg : succ
         */

        private String contents;
        private String upType;
        private String upurl;
        private String versionid;
        private String picName;
        private String picAddress;
        private String returnCode;
        private String returnMsg;

        public String getContents() {
            if (null == contents){

                return "";
            }
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public String getUpType() {
            return upType;
        }

        public void setUpType(String upType) {
            this.upType = upType;
        }

        public String getUpurl() {
            return upurl;
        }

        public void setUpurl(String upurl) {
            this.upurl = upurl;
        }

        public String getVersionid() {

            if (null == versionid){

                return "";
            }
            return versionid;
        }

        public void setVersionid(String versionid) {
            this.versionid = versionid;
        }

        public String getPicName() {
            return picName;
        }

        public void setPicName(String picName) {
            this.picName = picName;
        }

        public String getPicAddress() {
            return picAddress;
        }

        public void setPicAddress(String picAddress) {
            this.picAddress = picAddress;
        }

        public String getReturnCode() {

            if (null == returnCode){
                return "";
            }

            return returnCode;
        }

        public void setReturnCode(String returnCode) {
            this.returnCode = returnCode;
        }

        public String getReturnMsg() {
            return returnMsg;
        }

        public void setReturnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
        }
    }
}
