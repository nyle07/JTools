package com.nyle.jtools.httpdata;

/**
 * Created by NYL on 2017/3/7 0007.
 * Email:1174212579@qq.com
 */

public class BankBean {

    /**
     * result : {"cardtype":"借记卡","cardlength":19,"cardprefixnum":"622202","cardname":"E时代卡",
     * "bankname":"工商银行","banknum":"1020000"}
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
         * cardtype : 借记卡
         * cardlength : 19
         * cardprefixnum : 622202
         * cardname : E时代卡
         * bankname : 工商银行
         * banknum : 1020000
         */

        private String cardtype;
        private int cardlength;
        private String cardprefixnum;
        private String cardname;
        private String bankname;
        private String banknum;

        public String getCardtype() {
            return cardtype;
        }

        public void setCardtype(String cardtype) {
            this.cardtype = cardtype;
        }

        public int getCardlength() {
            return cardlength;
        }

        public void setCardlength(int cardlength) {
            this.cardlength = cardlength;
        }

        public String getCardprefixnum() {
            return cardprefixnum;
        }

        public void setCardprefixnum(String cardprefixnum) {
            this.cardprefixnum = cardprefixnum;
        }

        public String getCardname() {
            return cardname;
        }

        public void setCardname(String cardname) {
            this.cardname = cardname;
        }

        public String getBankname() {
            return bankname;
        }

        public void setBankname(String bankname) {
            this.bankname = bankname;
        }

        public String getBanknum() {
            return banknum;
        }

        public void setBanknum(String banknum) {
            this.banknum = banknum;
        }
    }
}
