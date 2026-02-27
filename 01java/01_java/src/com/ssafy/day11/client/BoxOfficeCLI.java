package com.ssafy.day11.client;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import com.ssafy.day11.dto.BoxOffice;
import com.ssafy.day11.parser.BoxOfficeDomParser;
import com.ssafy.day11.parser.BoxOfficeJsonParser;
import com.ssafy.day11.parser.BoxOfficeParser;
import com.ssafy.day11.parser.BoxOfficeSaxParser;

public class BoxOfficeCLI {
    private BoxOfficeParser parser = null;
    private InputStream resource = null;

    public static  enum Type{
        SAX, DOM, JSON
    }

    public List<BoxOffice> readBoxOfficeList(Type type) throws Exception {
        String file = null;
        // TODO: resource와 parser를 구성해서 정보를 가져와보자.

        // END

    }

    public static void main(String[] args) {
        BoxOfficeCLI cli = new BoxOfficeCLI();
        try {
            List<BoxOffice> result = cli.readBoxOfficeList(Type.SAX);
            result.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("오류 발생!: " + e.getMessage());
        }
    }
}
