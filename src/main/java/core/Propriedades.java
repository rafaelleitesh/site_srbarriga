package core;

public class Propriedades {

    public static Browsers BROWSER = Browsers.FIREFOX;

    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;

    public enum Browsers {
        CHROME,
        FIREFOX
    }

    public enum TipoExecucao {
        LOCAL,
        GRID
    }

}
