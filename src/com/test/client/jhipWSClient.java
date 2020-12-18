package com.test.client;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import java.net.URL;

/**
 * @Classname jhipWSClient
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-11-11 15:42
 * @Version 1.0
 **/
public class jhipWSClient {

    public static void main(String[] args) {

        String soapaction = "http://bjgoodwillcis.com";
        // webservice地址 （中文的可能需要进行URL编码）
        // 新增地址
        //String endpoint = "http://132.147.1.235/soap/JHIPLIB.SOAP.BS.Service.cls?CfgItem=JH1101%E6%B7%BB%E5%8A%A0%E4%BA%BA%E5%91%98";

        // 更新地址
        String endpoint = "http://132.147.1.235/soap/JHIPLIB.SOAP.BS.Service.cls?CfgItem=JH1102%E4%BF%AE%E6%94%B9%E4%BA%BA%E5%91%98";

        // 删除地址
        //String endpoint = "http://132.147.1.235/soap/JHIPLIB.SOAP.BS.Service.cls?CfgItem=JH1103%E5%88%A0%E9%99%A4%E4%BA%BA%E5%91%98";

        // ws目标空间
        String jsonStr = "<REQUEST>\n" +
                "    <ALIASNAME>人员维护</ALIASNAME>\n" +
                "    <TABLENAME>JHIP_EMUI_USER</TABLENAME>\n" +
                "    <IDENTIFICATION>update</IDENTIFICATION>\n" +
                "    <SUBSCRIBERS>jhip</SUBSCRIBERS><VALUE>\n" +
                "        <![CDATA[\n" +
                "        <DICT>\n" +
                "            <KEY>98765</KEY>\n" +
                "            <NAME>CESHI</NAME>\n" +
                "            <EMP_NO>98765</EMP_NO>\n" +
                "            <DEPT_CODE>4029</DEPT_CODE>\n" +
                "            <INPUT_CODE></INPUT_CODE>\n" +
                "            <SEX>0</SEX><BIRTH>1900-01-01</BIRTH>\n" +
                "            <CARD></CARD>\n" +
                "            <JOB></JOB>\n" +
                "            <TITLE></TITLE>\n" +
                "            <USER_NAME></USER_NAME>\n" +
                "            <INPUT_CODE_WB></INPUT_CODE_WB>\n" +
                "            <PHONE></PHONE>\n" +
                "            <RYID>6860</RYID>\n" +
                "            <FLAG>0</FLAG>\n" +
                "            <TIME>2020-11-17 15:11:20.017</TIME>\n" +
                "        </DICT>]]>\n" +
                "    </VALUE>\n" +
                "</REQUEST>\n";//拼接json字符串
        Service service = new Service();

        try {
            // 新建调用
            Call call = (Call) service.createCall();
            // 设置60S超时
            call.setTimeout(new Integer(600000));
            // 设置调用webservice地址
            call.setTargetEndpointAddress(new URL(endpoint));
            // 调用方法
            call.setOperationName(new QName(soapaction, "Send"));
            // 参数及类型
            call.addParameter("pInput", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            // 返回类型
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
            // 调用返回数据
            String a = (String) call.invoke(new Object[] { jsonStr });
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
