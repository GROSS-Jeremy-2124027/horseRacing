public class FrissonFactory implements ChevalFactory{


    @Override
    public Cheval createCheval() {
        return new Frisson();
    }
}
