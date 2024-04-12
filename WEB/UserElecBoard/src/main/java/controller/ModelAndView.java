package controller;

public class ModelAndView {
    private String ViewName;
    private boolean redirect;

    public ModelAndView(){}

    public ModelAndView(String viewName) {
        this.ViewName = viewName;
    }

    public ModelAndView(String ViewName, boolean redirect) {
        this(ViewName);
        this.redirect = redirect;
    }

    public String getViewName() {
        return ViewName;
    }

    public void setViewName(String viewName) {
        ViewName = viewName;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }
}
