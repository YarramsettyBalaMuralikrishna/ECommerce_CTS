package inClass;

abstract class Animal {
    private String name;
    public void setter(String name){
        this.name = name;
    }
    public String getter(){
        return  name;
    }
    public abstract void speak();
}
