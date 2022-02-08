package suite;

import org.junit.runner.RunWith;
import test.ContaTest;
import test.MovimentacaoTest;
import test.RemoverMovimentacaoTest;
import test.ResumoTest;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoTest.class,
        ResumoTest.class
})

public class Suite {
}
