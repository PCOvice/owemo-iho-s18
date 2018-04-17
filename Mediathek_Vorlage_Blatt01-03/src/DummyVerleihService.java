import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Diese Klasse implementiert das Interface VerleihService. Es handelt sich
 * lediglich um eine Dummy-Implementation, um die GUI zu testen.
 * 
 * @author GUI-Team
 * @version SoSe 2017
 */
class DummyVerleihService extends AbstractObservableService
        implements VerleihService
{
    // Generator für Zufallszahlen und zufällige boolsche Werte
    private static final Random RANDOM = new Random();

    private static final CD MEDIUM = new CD("Titel", "Kommentar", "Interpret",
            70);
    private static final Kundennummer KUNDENNUMMER = new Kundennummer(123456);
    private static final Kunde ENTLEIHER = new Kunde(KUNDENNUMMER, "Vorname",
            "Nachname");
    private static final Verleihkarte VERLEIHKARTE = new Verleihkarte(ENTLEIHER,
            MEDIUM, Datum.heute());

    public DummyVerleihService(KundenstammService kundenstamm,
            MedienbestandService medienbestand,
            List<Verleihkarte> initialBestand)
    {
    }

    @Override
    /**
     *  Es wird nur "MEDIUM" hinzugefügt. Es fehlen zum einen die Abhängigkeit von Kunden und die richtig implementierten
     *  Medien.
     */
    public List<Medium> getAusgelieheneMedienFuer(Kunde kunde)
    {
        List<Medium> ergebnisListe = new ArrayList<Medium>();
        ergebnisListe.add(MEDIUM);
        return ergebnisListe;
    }

    @Override
    /**
     * gibt nicht den gewünschten Entleiher sondern nur "Vorname und Nachname", Kundnummer 
     * bleibt immer "123456". 
     */
    public Kunde getEntleiherFuer(Medium medium)
    {
        return ENTLEIHER;
    }

    @Override
    /**
     * To-Do. Kein Ansatz welcher Kunde welche Medien ausgeliehen hat. 
     */
    public Verleihkarte getVerleihkarteFuer(Medium medium)
    {
        return VERLEIHKARTE;
    }

    @Override
    /**
     * Liste ist nicht nützlich. Sie fügt nur einmal verleihkarte ein, die auch nur einen beispielwert besitzt
     */
    public List<Verleihkarte> getVerleihkarten()
    {
        List<Verleihkarte> ergebnisListe = new ArrayList<Verleihkarte>();
        ergebnisListe.add(VERLEIHKARTE);
        return ergebnisListe;
    }

    @Override
    /**
     * gibt mir nur einen zufälligen Boolean wert aus. 
     */
    public boolean istVerliehen(Medium medium)
    {
        return RANDOM.nextBoolean();
    }

    @Override
    /**
     * To-Do
     */
    public void nimmZurueck(List<Medium> medien, Datum rueckgabeDatum)
    {
    }

    @Override
    /**
     * gibt mir nur einen zufälligen Boolean wert aus. 
     */
    public boolean sindAlleNichtVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }

    @Override
    /**
     * gibt mir nur einen zufälligen Boolean wert aus. 
     */
    public boolean sindAlleVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }

    @Override
    /**
     *  noch nichts implementiert.
     */
    public void verleiheAn(Kunde kunde, List<Medium> medien, Datum ausleihDatum)
    {
    }

    @Override
    /**
     * Entleiher ist kein richtiger Kunde.
     */
    public boolean kundeImBestand(Kunde kunde)
    {
        return ENTLEIHER.equals(kunde);
    }

    @Override
    /**
     * kein richtigker vergleich, da "MEDIUM" nicht wirklich exestiert.  
     */
    public boolean mediumImBestand(Medium medium)
    {
        return MEDIUM.equals(medium);
    }

    @Override
    /**
     * gibt mir nur einen zufälligen Boolean wert aus. 
     */
    public boolean medienImBestand(List<Medium> medien)
    {
        boolean result = true;
        for (Medium medium : medien)
        {
            if (!mediumImBestand(medium))
            {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    /**
     * Hier fehlt die abhängigkeit zum Kunden. Verleihkarte ist nur ein Platzhalter. 
     */
    public List<Verleihkarte> getVerleihkartenFuer(Kunde kunde)
    {
        List<Verleihkarte> result = new ArrayList<Verleihkarte>();
        result.add(VERLEIHKARTE);
        return result;
    }

    @Override
    /**
     *  To-Do, false wird nur ausgegeben. 
     */
    public boolean istVerleihenMoeglich(Kunde kunde, List<Medium> medien)
    {
        return false;
    }
}
