package utils;

public class AuthResponse 
{
    private String token;
    private String id;
    public AuthResponse(String token,String id)
    {
       this.token=token;
       this.id=id;
    }

    public String getToken()
    {
        return token;
    }

    public String getId()
    {
        return id;
    }
}
