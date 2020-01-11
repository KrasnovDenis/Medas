package nc.Medas.exception;


public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String param){
        super("Could't find by parameter "+ param );
    }
}
