package sr.unasat.jdbc.crud.app;

import jdk.swing.interop.LightweightFrameWrapper;
import sr.unasat.jdbc.crud.entities.*;
import sr.unasat.jdbc.crud.repositories.*;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        //Medicijnen --------------------------------------------------------------------
        //Table Medicijnen ophalen ------------------------------------------------------
        MedicijnenRepository medicijnenRepository = new MedicijnenRepository();
        List<Medicijnen> medicijnenList = medicijnenRepository.findAllRecords();
        for (Medicijnen medicijnen : medicijnenList) {
            System.out.println(medicijnen);
        }
        //Rijen invoeren
        medicijnenRepository.insertOneRecord(new Medicijnen("Malariadrug", 5500));
        //Rijen deleten
        medicijnenRepository.deleteOneRecord(new Medicijnen(10));
        //Specifieke rijen zoeken
        System.out.println(medicijnenRepository.findOneRecord(7));

        //Aftrekken uit de voorraad bij het verkopen
        medicijnenRepository.updateOneRecordVerkoop(new Medicijnen(1), 1000);

        //Optellen bij de voorraad als een medicijn bestelling is geleverd
        medicijnenRepository.updateOneRecordBestellingMedicijnen(new Medicijnen(1), 1000);

        //Wat moet besteld worden???
        System.out.println(medicijnenRepository.controle());


        //Bestellingen ------------------------------------------------------------------
        //Table Bestellingen ophalen ----------------------------------------------------
        BestellingenRepository bestellingenRepository = new BestellingenRepository();
        List<Bestellingen> bestellingenList = bestellingenRepository.findAllRecords();
        System.out.println("Table Bestellingen" +
                "\nBestelling_id | Datum                    | Aantal | Verantwoordelijke");
        for (Bestellingen bestellingen : bestellingenList) {
            System.out.println(bestellingen);
        }
        //Rijen invoeren
        bestellingenRepository.insertOneRecord(new Bestellingen("12-07-20", 1400, "Someone"), new Medicijnen(7));
        //Rijen deleten
        bestellingenRepository.deleteOneRecord(new Bestellingen(6));


        //Klanten -------------------------------------------------------------------------
        //Table Klanten ophalen -----------------------------------------------------------
        KlantenRepository klantenRepository = new KlantenRepository();
        List<Klanten> klantenList = klantenRepository.findAllRecords();
        for (Klanten klanten : klantenList) {
            System.out.println(klanten);
        }
        //Rijen invoeren
        klantenRepository.insertOneRecord(new Klanten("Ayaan", "Ramadhin", 2594215, "Somewhere"));
        //Rijen deleten
        klantenRepository.deleteOneRecord(new Klanten(7));
        //Zoek naar een bepaald klant met behulp van klant_id
        System.out.println(klantenRepository.findOneRecord(3));


        //TT_Medicijnen_Klanten ----------------------------------------------------
        //Table TT_Medicijnen_Klanten ophalen -------------------------------------------
        TT_Medicijnen_KlantenRepository tt_medicijnen_klantenRepository = new TT_Medicijnen_KlantenRepository();
        List<TT_Medicijnen_Klanten> med_klaList = tt_medicijnen_klantenRepository.findAllRecords();
        for (TT_Medicijnen_Klanten medicijnen_klanten : med_klaList) {
            System.out.println(medicijnen_klanten);
        }
        //Rijen invoeren
        tt_medicijnen_klantenRepository.insertOneRecord(new TT_Medicijnen_Klanten(new Medicijnen(7), new Klanten(3), 23));
        //Rijen deleten
        tt_medicijnen_klantenRepository.deleteOneRecord(new TT_Medicijnen_Klanten(new Medicijnen(3), new Klanten(3)));
        //De verkoop optellen (update)
        tt_medicijnen_klantenRepository.updateOneRecordVerkoop(new TT_Medicijnen_Klanten(new Medicijnen(3)), 10);
        //Update medicijn_id (foreign key)
        tt_medicijnen_klantenRepository.updateOneRecordMedicijn_id((new Medicijnen(5)),new Medicijnen(6));
        //Update klant_id (foriegn key)
        tt_medicijnen_klantenRepository.updateOneRecordKlant_id(new Klanten(6), new Klanten(4));







//TT_Medicijnen_klanten checken
/*
        PersoonRepository persoonRepo = new PersoonRepository();
        List<Persoon> persoonList = persoonRepo.findAllRecords();
        for (Persoon persoon : persoonList) {
            System.out.println(persoon);
        }

        ContactInformatieRepository ciRepo = new ContactInformatieRepository();
        List<ContactInformatie> contactList = ciRepo.findAllRecords();
        for (ContactInformatie contact : contactList) {
            System.out.println(contact);
        }
*/


        //   Persoon person = new Persoon(4);
        /*        persoonRepo.deleteOneRecord(person);*/

        //       int pk =persoonRepo.insertOneRecord(new Persoon("Ellen"));

//        ContactInformatieRepository ci = new ContactInformatieRepository();
//        ContactInformatie recordFound = ci.findOneRecord(1234, "Manjastraat 10");
//        System.out.println("single record: " + ci);
//
//        recordFound.setTelefoonNummer(8888);
//        recordFound.getPersoon().setId(4);
//        ci.updateOneRecord(recordFound);
//
//        System.out.println(ci.findAllRecords());


    }


}

