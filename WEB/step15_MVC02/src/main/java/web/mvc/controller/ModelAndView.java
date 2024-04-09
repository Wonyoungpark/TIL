package web.mvc.controller;

/*
결과뷰 이름과 이동방식을 관리하는 객체
 */
public class ModelAndView {
    private String viewName; //뷰 이름
    private boolean redirect; // 이동방식 : false=>forward , true=>redirect

    public ModelAndView() {
    }

    public ModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public ModelAndView(String viewName, boolean redirect) {
        this(viewName);
        this.redirect = redirect;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }
}
