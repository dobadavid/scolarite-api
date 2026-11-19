package com.tp.scolarite;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EtudiantControllerTest {

    private final EtudiantRepository repository = mock(EtudiantRepository.class);
    private final EtudiantController controller = new EtudiantController(repository);

    @Test
    void listerRetourneLesEtudiants() {
        when(repository.findAll()).thenReturn(List.of(
            new Etudiant("Mballa", "Paul", "paul@mail.cm")
        ));
        assertEquals(1, controller.lister().size());
    }

    @Test
    void creerEnregistreLEtudiant() {
        Etudiant etudiant = new Etudiant("Ngono", "Marie", "marie@mail.cm");
        when(repository.save(etudiant)).thenReturn(etudiant);
        Etudiant resultat = controller.creer(etudiant);
        assertEquals("Ngono", resultat.getNom());
        verify(repository).save(etudiant);
    }
}