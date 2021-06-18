Module soru3
    Public Class kontrol
        Public Function epostaKontrol(ByVal eposta As String) As Boolean

            If eposta.Length < 5 Then
                Return False
            End If

            Dim etIndex = eposta.IndexOf("@")
            If etIndex = -1 Or etIndex < 1 Then
                Return False
            End If

            Dim noktaIndex = eposta.LastIndexOf(".")
            If noktaIndex < etIndex Then
                Return False
            End If

            Return True
        End Function

        Public Function ipKontrol(ByVal ipadres As String) As Boolean
            Dim ipDizi = ipadres.Split(".")

            If ipDizi.Length < 4 Or ipDizi.Length > 4 Then
                Return False
            End If

            For index = 0 To ipDizi.Length - 1
                Dim parca = Convert.ToInt32(ipDizi(index))
                If parca < 0 Or parca > 255 Then
                    Return False
                End If
            Next

            Return True
        End Function

    End Class
    Sub Main()
        Dim k As New kontrol
        Console.WriteLine(k.epostaKontrol("abc@def.com"))
        Console.WriteLine(k.ipKontrol("123.45.67.8"))

        Console.ReadKey()
    End Sub

End Module
