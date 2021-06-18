Module soru2
    Public Class Erisim
        Public public_deger As String
        Private private_deger As String
        Friend friend_deger As String
        Protected protected_deger As String
        Protected Friend protectedfriend_deger As String


    End Class

    Sub Main()
        Dim erisim As New Erisim
        erisim.public_deger = "deneme"
        erisim.friend_deger = "deneme"
        erisim.protectedfriend_deger = "deneme"

        Console.WriteLine(erisim.public_deger)
        Console.WriteLine(erisim.friend_deger)
        Console.WriteLine(erisim.protectedfriend_deger)

        Console.ReadKey()
    End Sub

End Module
