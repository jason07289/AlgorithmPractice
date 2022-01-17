package d2022_01_03;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* 휴일정보 얻기 (한국)
// 공공데이타포털(http://www.data.go.kr) 오픈 API 이용 : 특일 정보제공 서비스
// http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo
//*/

public class HolidayInfo
{
	public static void main(String[] args) {
		ArrayList<String> o = new ArrayList<>();
		o.add("getHoliDeInfo");
		System.out.println(get(2022,2,o));
	}
    // [in] y : 년
    // [in] m : 월
    // [out] v[i*2 +0]=휴일날짜(YYYYMMDD), v[i*2 +1]=휴일 명칭
    // 반환값 : 에러메시지, null == OK
    public static String get(int y, int m, List<String> v)
    {
        HttpURLConnection con = null;
        String s = null; // 에러 메시지
       
        try
        {
            URL url = new URL(
                "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo"
                + "?ServiceKey=" // 서비스키
                + "&solYear=" + y  // 연도
                + "&solMonth=" + (m > 9 ? "" : "0") + m  // 월
                );
           
            con = (HttpURLConnection)url.openConnection();
            con.setRequestProperty("Accept-language", "ko");
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(con.getInputStream());

            boolean ok = false; // <resultCode>00</resultCode> 획득 여부
            System.out.println(ok);
            Element e;
            NodeList ns = doc.getElementsByTagName("header");
            if (ns.getLength() > 0)
            {
                e = (Element)ns.item(0);
                if (e.getElementsByTagName("resultCode").item(0).getTextContent().equals("00"))
                    ok = true; // 성공 여부
                else // 에러 메시지
                    s = e.getElementsByTagName("resultMsg").item(0).getTextContent();
            }
               
            if (ok)
            {
                ns = doc.getElementsByTagName("item");
                for (int i = 0; i < ns.getLength(); i++)
                {
                    e = (Element)ns.item(i);
                    v.add(e.getElementsByTagName("locdate").item(0).getTextContent()); // 날짜
                    v.add(e.getElementsByTagName("dateName").item(0).getTextContent()); // 명칭
                }
            }
        }
        catch (Exception e)
        {
            s = e.getMessage();
        }
       
        if (con != null)
            con.disconnect();

        return s;
    }
}