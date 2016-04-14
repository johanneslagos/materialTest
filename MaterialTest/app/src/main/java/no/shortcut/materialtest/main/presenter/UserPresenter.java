package no.shortcut.materialtest.main.presenter;

import no.shortcut.materialtest.main.model.User;
import no.shortcut.materialtest.main.model.UserInteractor;
import no.shortcut.materialtest.main.model.userContainer;
import no.shortcut.materialtest.main.view.IMainView;
import no.shortcut.materialtest.main.view.OnUserInteractorFinishedListener;
import retrofit2.Response;

/**
 * Created by Sijan Gurung on 11/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class UserPresenter implements IUserPresenter, OnUserInteractorFinishedListener{

    private IMainView view;
    private UserInteractor interactor;

    public UserPresenter(IMainView view) {
        this.view = view;
        this.interactor = new UserInteractor(this);
    }

    @Override
    public void loadUserData(String username) {
        interactor.loadUserInfo(username);
    }

    @Override
    public void OnNetworkSuccess(userContainer user, Response response) {
        view.onUserLoadSuccess(user,response);
    }

    @Override
    public void OnNetworkFailure(Throwable error) {
        view.onUserLoadFailure(error);
    }
}
