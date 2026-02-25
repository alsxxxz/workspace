import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatGPT {
//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
	private static String GMS_KEY = "S15P01Y158-9f3eeb1f-7fde-4788-a680-4adbad257515";
	private static String MODEL = "gpt-5-nano";
	//private static String END_POINT = "https://gms.ssafy.io/gmsapi/api.openai.com/v1/chat/completions";
	private static String END_POINT = "https://api.openai.com/v1/chat/completions";

	public static void main(String[] args) throws IOException {
		URL url = new URL(END_POINT);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("Authorization", "Bearer " + GMS_KEY);
		connection.setDoInput(true);
		connection.setDoOutput(true);

		JSONObject data = new JSONObject();
		data.put("model", MODEL);

		JSONObject message = new JSONObject();
		message.put("role", "user");
		message.put("content", "안녕? Chat GPT관련된 주제 3개만 추천해줘.");

		JSONArray messages = new JSONArray();
		messages.put(message);

		data.put("messages", messages);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
		bw.write(data.toString());
		bw.flush();
		bw.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line = null;

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		System.out.println(sb.toString());
	}
}