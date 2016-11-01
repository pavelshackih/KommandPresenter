package org.github.kommandpresenter.sample;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.github.kommandpresenter.Presenter;
import org.github.kommandpresenter.commands.SingleInstanceViewCommand;
import org.github.kommandpresenter.commands.OneTimeViewCommand;
import org.github.kommandpresenter.commands.ProgressViewCommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListPresenter extends Presenter {

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com";
    public static final String POSTS = BASE_URL + "/posts/%s";
    public static final int MAX = 10;
    public static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    public volatile boolean isRefreshing = false;

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        onRefresh();
    }

    public void onRefresh() {
        if (isRefreshing) {
            return;
        }
        isRefreshing = true;
        applyCommand(ProgressViewCommand.INSTANCE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Pojo> result = new ArrayList<>();
                for (int i = 1; i <= MAX; i++) {
                    Request.Builder builder = new Request.Builder();
                    Request request = builder.get().url(String.format(POSTS, i)).build();
                    try {
                        Response response = HTTP_CLIENT.newCall(request).execute();
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        Pojo pojo = new Pojo();
                        pojo.userId = jsonObject.getString("userId");
                        pojo.id = jsonObject.getString("id");
                        pojo.title = jsonObject.getString("title");
                        pojo.body = jsonObject.getString("body");
                        result.add(pojo);
                    } catch (IOException | JSONException ignored) {
                        applyCommand(new ErrorCommand("Error while loading posts!"));
                        isRefreshing = false;
                        return;
                    }
                }
                applyCommand(new PostsCommand(result));
                isRefreshing = false;
            }
        }).start();
    }

    public static class Pojo {
        String userId;
        String id;
        String title;
        String body;
    }

    public static class PostsCommand implements SingleInstanceViewCommand {

        final List<Pojo> data;

        public PostsCommand(List<Pojo> data) {
            this.data = data;
        }
    }

    public static class ErrorCommand implements OneTimeViewCommand {

        final String error;

        public ErrorCommand(String error) {
            this.error = error;
        }
    }
}