package karaokelist.material.com.karaokelist.object;

public class Obj_loai_bh {
    private String countryName;
    private long countryPopulation;
    private int countryFlag; // Populate it with our resource ID for the correct image.
    
    public Obj_loai_bh(String cName, long cPopulation, int flagImage)
    {
        countryName = cName;
        countryPopulation = cPopulation;
        countryFlag = flagImage;
    }
    public String getCountryName()
    {
        return countryName;
    }
    public long getCountryPopulation()
    {
        return countryPopulation;
    }
    public int getCountryFlag()
    {
        return countryFlag;
    }
    public String toString()
    {
        return countryName;
    }
}
