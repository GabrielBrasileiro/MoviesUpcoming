package universodoandroid.br.com.moviesupcoming.policy;

public interface BaseLocalDataSource {
    interface LocalDataSourceCallback<R> {
        void onSuccess(R response);
        void onError(String errorResponse);
    }
}
