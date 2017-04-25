package modelo;


public class CuentasUploadTest {
    String jsonString = "";


    public Empresa procesarArchivo() {
        return new JsonParser().construirEmpresa(jsonString);
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

}