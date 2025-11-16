package acme;



import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.azure.core.credential.AzureKeyCredential;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        String AZURE_API_KEY = "<YOUR KEY>";
        String AZURE_ENDPOINT = "<END POINT>";
        String DEPLOYMENT_NAME = "gpt-5-mini";
        OpenAIClient client = (new OpenAIClientBuilder()).endpoint(AZURE_ENDPOINT).credential(new AzureKeyCredential(AZURE_API_KEY)).buildClient();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ask me anything: ");
        String question = scanner.nextLine();
        scanner.close();
        ChatRequestUserMessage userMessage = new ChatRequestUserMessage(question);
        ChatCompletionsOptions chatOptions = new ChatCompletionsOptions(Arrays.asList(userMessage));
        System.out.println("Thinking...");
        ChatCompletions chatCompletions = client.getChatCompletions(DEPLOYMENT_NAME, chatOptions);
        String responseContent = ((ChatChoice)chatCompletions.getChoices().get(0)).getMessage().getContent();
        System.out.println(responseContent);
    }

}