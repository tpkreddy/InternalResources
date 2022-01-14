
package com.google.accenture.myapplication.modelclasses;

import java.util.HashMap;
import java.util.Map;


public class ListPrice__1 {

    private long amountInMicros;
    private String currencyCode;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public long getAmountInMicros() {
        return amountInMicros;
    }

    public void setAmountInMicros(long amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
