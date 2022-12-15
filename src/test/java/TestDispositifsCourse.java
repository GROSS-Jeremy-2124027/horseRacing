import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la mise en place de la course
 */
public class TestDispositifsCourse {
    protected DispositifsDeLaCourse course;

    @BeforeEach
    public void init() {
        course = new DispositifsDeLaCourse(5, 2.5);
    }

    /**
     * Test permettant de savoir s'il ya autant de chevaux que de threads lancés
     */
    @Test
    public void testPourSavoirSiIlYAAutantDeThreadsQueDeChevaux() {
        assertEquals(course.getListeThread().size(), course.getChevauxDeCourse().size());
    }

    /**
     * Test permettant de savoir si les clés du dictionnaire de positions des chevaux correspondent bien aux numéros
     * des chevaux en course
     */
    @Test
    public void testPourSavoirSiLesClesDuDictionnaireDePositionsCorrespondentAuxNumerosDesChevaux() {
        List<Integer> listeTest = new ArrayList<>();
        DispositifsDeLaCourse.getDictionnairePosition().keySet().forEach(cle -> listeTest.add(cle));
        for (int i = 0; i < course.getChevauxDeCourse().size(); i += 1) {
            assertEquals(course.getChevauxDeCourse().get(i).getNumeroCheval(), listeTest.get(i));
        }
    }

    /**
     * Test permettant de savoir si les valeurs du dictionnaire de positions sont bien initialisés à zéro
     */
    @Test
    public void testPourSavoirSiToutesLesValeursDuDictionnaireDePositionsSontAZero() {
        for (AtomicInteger atomicInteger : course.getDictionnairePosition().values()) {
            assertEquals(atomicInteger.get(), 0);
        }
    }

    /**
     * Test permettant de savoir si l'on arrive bien à trouver un vainqueur dans la course de chevaux
     */
    @Test
    public void testPourSavoirSiOnTrouveUnChevalVainqueur() {
        DispositifsDeLaCourse.getDictionnairePosition().put(2, new AtomicInteger(10));
        assertNotNull(course.trouveVainqueur());
    }

    /**
     *  Test permttant de savoir si les valeurs des clées du dictionnaire de position sont bien remises à zéro
     *  après une course
     */
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

    /**
     * Test permettant de savoir si tous les parieurs on perdu leurs paris
     */
    @Test
    public void testPourSavoirSiTousLesParieursOntPerdu() {
        course.getParieursDeLaCourse().clear();
        assertTrue(course.defaiteGenerale());
    }

}
