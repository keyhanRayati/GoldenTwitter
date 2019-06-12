package ir.co.arca.twitter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiService {
    public static final String TAG = "ApiService";
    private static final String BASE_URL = "http://192.168.1.120:3000/";
    private Context context;
    private SharedPreferences sharedPreferences;

    public ApiService(Context context) {
        sharedPreferences = context.getSharedPreferences("gt_sp", Context.MODE_PRIVATE);
        this.context = context;
    }

    void signup(String username, String password, String email, String fullname, final OnServerCallback onServerCallback) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("fullname", fullname);
            jsonObject.put("email", email);
            jsonObject.put("username", username);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, BASE_URL + "/signup", jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                onServerCallback.onSuccess();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "onErrorResponse: cccc " + error.networkResponse.statusCode);
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }

    void login(String username, String password, final OnServerCallback onServerCallback) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", username);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, BASE_URL + "/login", jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    sharedPreferences.edit()
                            .putString("token", response.getString("token"))
                            .putBoolean("isLogin", true).apply();
                    onServerCallback.onSuccess();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "onErrorResponse: cccc " + error.networkResponse.statusCode);
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }

    void getTweets(final OnTweetsReceived onTweetsReceived) {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BASE_URL + "tweet/show", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                onTweetsReceived.onSuccess(getTweetFromJsonArray(response));
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("cccc", "onResponse: " + error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return getAuthorization();
            }
        };
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }

    private Map<String, String> getAuthorization() {
        Map<String, String> params = new HashMap<>();
        params.put("Authorization", "Barer " + sharedPreferences.getString("token", ""));
        return params;
    }

    void getUser(final OnUserReceived onUserReceived) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL + "?username=hasan", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    onUserReceived.onSuccess(getUserFromJson(response));

                } catch (JSONException e) {
                    Log.i("cccc", "onResponse: " + e.getMessage());
                    e.printStackTrace();
                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("cccc", "onResponse: " + error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return getAuthorization();
            }
        };

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }

    private User getUserFromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user._id = jsonObject.getString("_id");
        user.bio = jsonObject.getString("bio");
        user.followers = getFollowFromJson(jsonObject.getJSONArray("follower"));
        user.followings = getFollowFromJson(jsonObject.getJSONArray("following"));
        user.name = jsonObject.getString("fullname");
        return user;
    }

    private List<Tweet> getTweetFromJsonArray(JSONArray jsonArray) {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Tweet tweet = new Tweet(R.drawable.default_avatar,
                        jsonObject.getJSONObject("twitter").getString("fullname"),
                        jsonObject.getJSONObject("twitter").getString("username"),
                        jsonObject.getString("date"),
                        jsonObject.getString("status"),
                        R.drawable.ic_mention, R.drawable.ic_renew,
                        R.drawable.ic_favorite,
                        String.valueOf(jsonObject.getJSONArray("comment").length()),
                        String.valueOf(jsonObject.getJSONArray("retweet").length()),
                        String.valueOf(jsonObject.getJSONArray("like").length())
                );
                tweet.setComments(getCommentsFromJsonArray(jsonObject.getJSONArray("comment")));
                tweets.add(tweet);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return tweets;
    }

    private List<Tweet> getCommentsFromJsonArray(JSONArray jsonArray) {
        List<Tweet> comments = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Tweet cm = new Tweet(R.drawable.default_avatar, jsonObject.getString("username"),
                        "@" + jsonObject.getString("username"), "", jsonObject.getString("content"),
                        0, 0, 0, "", "", "");
                comments.add(cm);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return comments;
    }

    private List<Follow> getFollowFromJson(JSONArray follower) throws JSONException {
        List<Follow> follows = new ArrayList<>();
        for (int i = 0; i < follower.length(); i++) {
            Follow follow = new Follow();
            JSONObject jsonObject = follower.getJSONObject(i);
            follow._id = jsonObject.getString("_id");
            follow.name = jsonObject.getString("username");
            follows.add(follow);

        }

        return follows;
    }

    interface OnTweetsReceived {
        void onSuccess(List<Tweet> tweets);

        void onFailed();
    }

    interface OnUserReceived {
        void onSuccess(User user);

        void onFailed();
    }

    interface OnServerCallback {
        void onSuccess();

        void onFailed();
    }
}
