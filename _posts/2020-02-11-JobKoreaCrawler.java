package com.kyk;

import java.io.File;
import java.io.FileWriter;
import java.util.StringTokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Jobkorea {
//지원현황 페이지에서 '저장' -> String URL에 경로와 파일명 일치시키기. -> String createfile의 경로와 파일명 확인하고 실행한다.
		public static void main(String[] args) throws Exception {
//			String URL = "https://www.jobkorea.co.kr/Starter/AptitudeTest/JatTest";
			String URL = "C:\\Users\\user\\Desktop\\myjobko.html";
			
			File input = new File("C:\\Users\\user\\Desktop\\myjobko.html");
			Document doc = Jsoup.parse(input, "UTF-8", "");
			
//			Document doc = Jsoup.connect(URL).get();
			Elements elem = doc.select("table");
			String str = elem.text();
			String companyName = doc.getElementsByClass("company").text();//회사명
			
			companyName=companyName.replace("관심기업", "");
			StringTokenizer stk = new StringTokenizer(companyName," ");
			
			String createfile="C:\\Users\\user\\Desktop\\myJobKoreaApply.csv";
			FileWriter fw = new FileWriter(createfile);
			
			while(stk.hasMoreTokens()){
				fw.append(stk.nextToken());
				fw.append(',');
				fw.append("지원완료");
				fw.append('\n');
			}
			fw.flush();
			fw.close();
		}
}
