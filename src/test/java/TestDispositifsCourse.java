import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class TestDispositifsCourse {
    protected DispositifsDeLaCourse course;

    @BeforeEach
    public void init() {
        course = new DispositifsDeLaCourse(5, 2.5);
    }

    @Test
    public void testPourSavoirSiIlYAAutantDeThreadsQueDeChevaux() {
        assertEquals(course.getListeThread().size(), course.getChevauxDeCourse().size());
    }

    @Test
    public void testPourSavoirSiLesClesDuDictionnaireDePositionsCorrespondentAuxNumerosDesChevaux() {
        List<Integer> listeTest = new ArrayList<>();
        DispositifsDeLaCourse.getDictionnairePosition().keySet().forEach(cle -> listeTest.add(cle));
        for (int i = 0; i < course.getChevauxDeCourse().size(); i += 1) {
            assertEquals(course.getChevauxDeCourse().get(i).getNumeroCheval(), listeTest.get(i));
        }
    }

    @Test
    public void testPourSavoirSiToutesLesValeursDuDictionnaireDePositionsSontAZero() {
        for (AtomicInteger atomicInteger : course.getDictionnairePosition().values()) {
            assertEquals(atomicInteger.get(), 0);
        }
    }

    @Test
    public void testPourSavoirSiOnTrouveUnChevalVainqueur() {
        DispositifsDeLaCourse.getDictionnairePosition().put(2, new AtomicInteger(10));
        assertNotNull(course.trouveVainqueur());
    }

    @Test
    public void testPourSavoirSiOnRemetBienLesValeursDesClesAZero() {
        DispositifsDeLaCourse.getDictionnairePosition().put(2, new AtomicInteger(10));
        DispositifsDeLaCourse.getDictionnairePosition().put(1, new AtomicInteger(7));
        DispositifsDeLaCourse.getDictionnairePosition().put(3, new AtomicInteger(2));
        DispositifsDeLaCourse.getDictionnairePosition().put(4, new AtomicInteger(8));
        course.remettreChevalSurLigneDeDépart();

        for (AtomicInteger atomicInteger : DispositifsDeLaCourse.getDictionnairePosition().values()) {
            assertEquals(atomicInteger.get(), 0);
        }
    }

    @Test
    public void testPourSavoirSiTousLesParieursOntPerdu() {
        course.getParieursDeLaCourse().clear();
        assertTrue(course.defaiteGenerale());
    }

}
