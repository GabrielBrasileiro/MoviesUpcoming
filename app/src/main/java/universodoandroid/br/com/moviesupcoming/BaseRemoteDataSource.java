package universodoandroid.br.com.moviesupcoming;

public class BaseRemoteDataSource {
    public interface RemoteDataSourceCallback<R> {
        void onSuccess(R response);
        void onError(String  errorResponse);
    }

    public interface VoidRemoteDataSourceCallback {
        void onSuccess();
        void onError(String errorResponse);
    }
}
