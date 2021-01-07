public enum RoomType {

    SINGLE(50),
    DOUBLE(100);

    private final int nightlyRate;

    RoomType(int nightlyRate){
        this.nightlyRate = nightlyRate;
    }

    public int getNightlyRate(){
        return nightlyRate;
    }

}
