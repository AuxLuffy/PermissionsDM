package com.lenovo.sunzh.permissionsdm.custom;

import java.util.List;

/**
 * Created by sunzh on 2017/2/16.
 */

public class Tst {

    /**
     status : 00
     msg : success
     newsCommentVos : [{"id":"1","rid":"0","content":"qqq","userKey":"1","userKeyName":"","userPkey":"","userPkeyName":"","replyCount":"0","createTime":"2017-02-07 15:49:36","pid":"0","userInfo":{"id":"2","usercode":"1","nickname":"","userHeadPicCode":"","realname":"","qq":"","sex":"","age":"","birthday":"1486454260478","weixinId":"","createTime":"1486454260521","updateTime":"1486454260529","position":"","industries":"","signature":"","province":"","city":"","country":"","areaDetail":"","hobbyAreas":"","userGrade":"V1","userTypeCode":"1","activeDu":"","isUpdate":"0","remark":""}}]
     detailVo : {"title":"中税网","content":"","createTime":"2017-02-13 09:56:49","praise":"0","trample":"0","readAmount":"1","comment":"8"}
     */

    private String status;
    private String msg;
    private DetailVoBean detailVo;
    private List<NewsCommentVosBean> newsCommentVos;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DetailVoBean getDetailVo() {
        return detailVo;
    }

    public void setDetailVo(DetailVoBean detailVo) {
        this.detailVo = detailVo;
    }

    public List<NewsCommentVosBean> getNewsCommentVos() {
        return newsCommentVos;
    }

    public void setNewsCommentVos(List<NewsCommentVosBean> newsCommentVos) {
        this.newsCommentVos = newsCommentVos;
    }

    public static class DetailVoBean {
        /**
         * title : 中税网
         * content :
         * createTime : 2017-02-13 09:56:49
         * praise : 0
         * trample : 0
         * readAmount : 1
         * comment : 8
         */

        private String title;
        private String content;
        private String createTime;
        private String praise;
        private String trample;
        private String readAmount;
        private String comment;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getPraise() {
            return praise;
        }

        public void setPraise(String praise) {
            this.praise = praise;
        }

        public String getTrample() {
            return trample;
        }

        public void setTrample(String trample) {
            this.trample = trample;
        }

        public String getReadAmount() {
            return readAmount;
        }

        public void setReadAmount(String readAmount) {
            this.readAmount = readAmount;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

    public static class NewsCommentVosBean {
        /**
         * id : 1
         * rid : 0
         * content : qqq
         * userKey : 1
         * userKeyName :
         * userPkey :
         * userPkeyName :
         * replyCount : 0
         * createTime : 2017-02-07 15:49:36
         * pid : 0
         * userInfo : {"id":"2","usercode":"1","nickname":"","userHeadPicCode":"","realname":"","qq":"","sex":"","age":"","birthday":"1486454260478","weixinId":"","createTime":"1486454260521","updateTime":"1486454260529","position":"","industries":"","signature":"","province":"","city":"","country":"","areaDetail":"","hobbyAreas":"","userGrade":"V1","userTypeCode":"1","activeDu":"","isUpdate":"0","remark":""}
         */

        private String id;
        private String rid;
        private String content;
        private String userKey;
        private String userKeyName;
        private String userPkey;
        private String userPkeyName;
        private String replyCount;
        private String createTime;
        private String pid;
        private UserInfoBean userInfo;
        private List<NewsCommentVosBean> newsCommentVos;
        public List<NewsCommentVosBean> getNewsCommentVos() {
            return newsCommentVos;
        }

        public void setNewsCommentVos(List<NewsCommentVosBean> newsCommentVos) {
            this.newsCommentVos = newsCommentVos;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUserKey() {
            return userKey;
        }

        public void setUserKey(String userKey) {
            this.userKey = userKey;
        }

        public String getUserKeyName() {
            return userKeyName;
        }

        public void setUserKeyName(String userKeyName) {
            this.userKeyName = userKeyName;
        }

        public String getUserPkey() {
            return userPkey;
        }

        public void setUserPkey(String userPkey) {
            this.userPkey = userPkey;
        }

        public String getUserPkeyName() {
            return userPkeyName;
        }

        public void setUserPkeyName(String userPkeyName) {
            this.userPkeyName = userPkeyName;
        }

        public String getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(String replyCount) {
            this.replyCount = replyCount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * id : 2
             * usercode : 1
             * nickname :
             * userHeadPicCode :
             * realname :
             * qq :
             * sex :
             * age :
             * birthday : 1486454260478
             * weixinId :
             * createTime : 1486454260521
             * updateTime : 1486454260529
             * position :
             * industries :
             * signature :
             * province :
             * city :
             * country :
             * areaDetail :
             * hobbyAreas :
             * userGrade : V1
             * userTypeCode : 1
             * activeDu :
             * isUpdate : 0
             * remark :
             */

            private String id;
            private String usercode;
            private String nickname;
            private String userHeadPicCode;
            private String realname;
            private String qq;
            private String sex;
            private String age;
            private String birthday;
            private String weixinId;
            private String createTime;
            private String updateTime;
            private String position;
            private String industries;
            private String signature;
            private String province;
            private String city;
            private String country;
            private String areaDetail;
            private String hobbyAreas;
            private String userGrade;
            private String userTypeCode;
            private String activeDu;
            private String isUpdate;
            private String remark;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUsercode() {
                return usercode;
            }

            public void setUsercode(String usercode) {
                this.usercode = usercode;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getUserHeadPicCode() {
                return userHeadPicCode;
            }

            public void setUserHeadPicCode(String userHeadPicCode) {
                this.userHeadPicCode = userHeadPicCode;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getWeixinId() {
                return weixinId;
            }

            public void setWeixinId(String weixinId) {
                this.weixinId = weixinId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getIndustries() {
                return industries;
            }

            public void setIndustries(String industries) {
                this.industries = industries;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getAreaDetail() {
                return areaDetail;
            }

            public void setAreaDetail(String areaDetail) {
                this.areaDetail = areaDetail;
            }

            public String getHobbyAreas() {
                return hobbyAreas;
            }

            public void setHobbyAreas(String hobbyAreas) {
                this.hobbyAreas = hobbyAreas;
            }

            public String getUserGrade() {
                return userGrade;
            }

            public void setUserGrade(String userGrade) {
                this.userGrade = userGrade;
            }

            public String getUserTypeCode() {
                return userTypeCode;
            }

            public void setUserTypeCode(String userTypeCode) {
                this.userTypeCode = userTypeCode;
            }

            public String getActiveDu() {
                return activeDu;
            }

            public void setActiveDu(String activeDu) {
                this.activeDu = activeDu;
            }

            public String getIsUpdate() {
                return isUpdate;
            }

            public void setIsUpdate(String isUpdate) {
                this.isUpdate = isUpdate;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }
        }
    }
}
