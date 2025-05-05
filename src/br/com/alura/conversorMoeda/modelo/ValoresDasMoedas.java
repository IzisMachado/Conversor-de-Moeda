package br.com.alura.conversorMoeda.modelo;

import com.google.gson.annotations.SerializedName;

public class ValoresDasMoedas {
    @SerializedName("result")
    private String result;

    @SerializedName("conversion_rate")
    private double conversionRate;

    @SerializedName("error-type")
    private String errorType;

    public String getResult() {
        return result;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public String getErrorType() {
        return errorType;
    }
}
