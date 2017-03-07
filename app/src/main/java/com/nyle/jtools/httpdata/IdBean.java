package com.nyle.jtools.httpdata;

/**
 * Created by NYL on 2017/3/7 0007.
 * Email:1174212579@qq.com
 */

public class IdBean {


    /**
     * result : {"address":"河南省禹州市","sex":"M","birthday":"1992-12-07"}
     * error_code : 0
     * reason : Succes
     */

    private ResultBean result;
    private int error_code;
    private String reason;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean {
        /**
         * address : 河南省禹州市
         * sex : M
         * birthday : 1992-12-07
         */

        private String address;
        private String sex;
        private String birthday;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }
}
