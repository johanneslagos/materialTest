package no.shortcut.materialtest.main.ui;

import no.shortcut.materialtest.main.model.userContainer;
import retrofit2.Response;

/**
 * Created by Sijan Gurung on 13/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public interface OnUserInteractorFinishedListener {
    void OnNetworkSuccess(userContainer userContainer, Response response);
    void OnNetworkFailure(Throwable error);
}
