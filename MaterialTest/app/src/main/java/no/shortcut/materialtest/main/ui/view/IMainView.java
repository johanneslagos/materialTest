package no.shortcut.materialtest.main.ui.view;

import no.shortcut.materialtest.main.model.userContainer;
import retrofit2.Response;

/**
 * Created by Sijan Gurung on 13/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public interface IMainView {
    void onUserLoadSuccess(userContainer user, Response response);
    void onUserLoadFailure(Throwable error);
}
