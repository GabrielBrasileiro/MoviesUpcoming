package universodoandroid.br.com.moviesupcoming;

public interface UseCase {

    interface LoadUseCaseCallback<R> {
        void onLoaded(R response);
        void onEmptyData();
        void onFailed(String errorDescription);
    }

}
