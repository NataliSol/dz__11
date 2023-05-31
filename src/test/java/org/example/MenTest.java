package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenTest {

    private Men men;
    private Woman womanAngelina;
    private Woman womanScarlett;

    @BeforeMethod
    public void creatingMenBrad() {
        men = new Men("Brad", "Pitt", 64);
    }

    public void creatingWomanAngelina() {
        womanAngelina = new Woman("Angelina", "Jolie", 59);
    }

    public void creatingWomanScarlett() {
        womanScarlett = new Woman("Scarlett", "Johansson", 40);
    }


    @Test
    public void newMenHasNoPartner_test() {
        Assert.assertNull(men.getPartner());
    }

    @Test
    public void getterSetterLastName_test() {
        men.setLastName("Nancy");
        Assert.assertEquals(men.getLastName(), "Nancy");
    }

    @Test
    public void isRetiredFalseTest() {
        Assert.assertFalse(men.isRetired());
    }

    @Test
    public void isRetiredTrueTest() {
        men.happyBirthday();
        Assert.assertTrue(men.isRetired());
    }

    @Test
    public void RegisterPartnershipSuccess_test() {
        creatingWomanAngelina();
        men.registerPartnership(womanAngelina);
        Assert.assertNotNull(men.getPartner());
        Assert.assertEquals(men.getPartner().getFirstName(), "Angelina");
        Assert.assertEquals(men.getPartner().getLastName(), "Pitt");
    }

    @Test
    public void noChangeLastNameAfterRegisterPartnershipTest() {
        creatingWomanAngelina();
        men.registerPartnership(womanAngelina);
        Assert.assertEquals(men.getLastName(), "Pitt");
    }

    @Test
    public void noChangeWomanMaidenNameAfterMarriage_test() {
        creatingWomanAngelina();
        men.registerPartnership(womanAngelina);
        Assert.assertEquals(womanAngelina.getMaidenName(), "Jolie");
    }

    @Test
    public void impossibilityToChangeHusbandWithoutDivorce_test() {
        creatingWomanAngelina();
        creatingWomanScarlett();
        men.registerPartnership(womanAngelina);
        men.registerPartnership(womanScarlett);
        Assert.assertEquals(men.getPartner().getFirstName(), "Angelina");
        Assert.assertEquals(men.getPartner().getLastName(), "Pitt");
    }

    @Test
    public void impossibilityChangeWomanLastNameWithoutDivorce_test() {
        creatingWomanAngelina();
        creatingWomanScarlett();
        men.registerPartnership(womanAngelina);
        men.registerPartnership(womanScarlett);
        Assert.assertEquals(womanAngelina.getLastName(), "Pitt");
        Assert.assertEquals(womanScarlett.getLastName(), "Johansson");
    }

    @Test
    public void checkingThatPartnerIsChangeForMenAfterMarriageTest() {
        creatingWomanAngelina();
        men.registerPartnership(womanAngelina);
        Assert.assertEquals(men.getPartner().getFirstName(), "Angelina");
        Assert.assertEquals(men.getPartner().getLastName(), "Pitt");
    }

    @Test
    public void setMaidenNameToWomanAfterDeregisterPartnership() {
        creatingWomanAngelina();
        men.registerPartnership(womanAngelina);
        men.deregisterPartnership();
        Assert.assertEquals(womanAngelina.getLastName(), "Jolie");
    }

    @Test
    public void checkPartnerIsNullAfterDeregisterPartnership() {
        creatingWomanAngelina();
        men.registerPartnership(womanAngelina);
        men.deregisterPartnership();
        Assert.assertNull(men.getPartner());
        Assert.assertNull(womanAngelina.getPartner());
    }
}