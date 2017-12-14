package ayur.arkhipov.ru.battlenetoauthapp.mvp.base;


public abstract class BasePresenter<V extends BaseView> {

    private V view;

    public final void attachView(V view) {
        if (view == null) throw new NullPointerException("View can't be null");
        this.view = view;
        updateView();
    }

    public final void detachView() {
        view = null;
    }

    /*
    * use when view attached
    * */
    public abstract void updateView();

    public final boolean viewIsAttached() {
        return view != null;
    }

    public final V getView() {
        return view;
    }

}
