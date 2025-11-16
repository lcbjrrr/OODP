package org.example;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;

import java.util.*;

import com.azure.ai.openai.models.*;
import com.azure.core.credential.AzureKeyCredential;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.annotation.FunctionName;

public class Main {
//Libs!! https://github.com/lcbjrrr/lcbjrrr/raw/refs/heads/master/lib.zip
    @FunctionName("llmchat")
    public HttpResponseMessage run(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        context.getLogger().info("Java HTTP trigger - processing request.");

        // Get the query parameter “name”
        String question = request.getQueryParameters().get("question");

        if (question == null) {
            return request
                    .createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Please pass a name on the query string ?name=Luiz")
                    .build();
        }

        String AZURE_API_KEY = "<YOUR_AZURE_API_KEY>";
        String AZURE_ENDPOINT = "ENDPOINT";
        String DEPLOYMENT_NAME = "gpt-5-mini";

        OpenAIClient client = (new OpenAIClientBuilder()).endpoint(AZURE_ENDPOINT).credential(new AzureKeyCredential(AZURE_API_KEY)).buildClient();
        ChatRequestUserMessage userMessage = new ChatRequestUserMessage(question);
        ChatCompletionsOptions chatOptions = new ChatCompletionsOptions(Arrays.asList(userMessage));
        System.out.println("Thinking...");
        ChatCompletions chatCompletions = client.getChatCompletions("gpt-5-mini", chatOptions);
        String responseContent = ((ChatChoice)chatCompletions.getChoices().get(0)).getMessage().getContent();
        System.out.println(responseContent);

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(responseContent)
                .build();
    }

}
