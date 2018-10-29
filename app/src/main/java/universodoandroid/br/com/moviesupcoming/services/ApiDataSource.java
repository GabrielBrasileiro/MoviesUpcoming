package universodoandroid.br.com.moviesupcoming.services;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiDataSource {

    private static ApiDataSource INSTANCE = null;
    private final String mBaseUrl;

    private ApiDataSource(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    public static ApiDataSource getInstance(String baseUrl) {
        if (INSTANCE == null)
            INSTANCE = new ApiDataSource(baseUrl);

        return INSTANCE;
    }

    public <S> S createService(Class<S> serviceClass) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient.build())
                .build();

        return retrofit.create(serviceClass);
    }

}
