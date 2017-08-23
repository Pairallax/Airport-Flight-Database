public class Flight {
    private Airplane airPlane;
    private String departureCode;
    private String destinationCode;

    public Flight(Airplane airPlane, String departureCode, String destinationCode){
        this.airPlane = airPlane;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
    }

    public String toString(){
        return this.airPlane + " (" + this.departureCode + "-" + this.destinationCode + ")";
    }

}