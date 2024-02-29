package practice6.Builder;

public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    public void construct(){
        builder.buildFloor();
        builder.buildWall();
        builder.buildRoof();
    }
}
