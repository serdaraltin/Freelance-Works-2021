using System.Collections.Generic;

namespace cemgu
{

    class person
    {
        public int no;
        public string name;
        public string surname;
        public string sex;

        public person()
        {

        }
        public person(int no, string name, string surname, string sex)
        {
            this.no = no;
            this.name = name;
            this.surname = surname;
            this.sex = sex;
        }
    }

    class artist : person
    {
        public int experienceYear;
        public int award;
        public string birthDate;

        artist()
        {

        }
        artist(int no, string name, string surname, string sex, int experienceYear, int award, string birthDate)
            : base(no, name, surname, sex)
        {

            this.experienceYear = experienceYear;
            this.award = award;
            this.birthDate = birthDate;
        }
    }

    class director : person
    {
        public int filmCount;

        director()
        {

        }
        director(int no, string name, string surname, string sex, int filmCount)
            : base(no, name, surname, sex)
        {
            this.filmCount = filmCount;
        }
    }
    class customer : person
    {
        public string kayitTarih;
    }

    class livingRoom
    {
        public int no;
        public int koltukAdet;
        public int[] koltukDurum;
    }

    class film
    {
        public string name;
        public string tur;
        public string dil;
        string yapim;
        public director director;
        public List<artist> artists = new List<artist>();
    }

    class session
    {
        public int no;
        public film film;
        public livingRoom livingRoom;
        public string startDate;
        public string finishDate;

    }

    class ticket
    {
        public int no;
        public customer customer;
        public session session;
        public string salesDate;
    }

    class operation
    {
        public film selectFilm()
        {
            return new film();
        }
        public customer listOrCreateCustomer()
        {
            return new customer();
        }

        public session selectSession(film film)
        {
            return new session();
        }

        public ticket createTicket(customer customer, session session)
        {
            return new ticket();
        }
        public void saleTicket()
        {
            customer customer = listOrCreateCustomer();
            film film = selectFilm();
            session session = selectSession(film);
            ticket ticket = createTicket(customer, session);
        }

    }

    class Program
    {
        static void Main(string[] args)
        {

        }
    }
}
