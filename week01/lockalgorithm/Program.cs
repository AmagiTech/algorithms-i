// See https://aka.ms/new-console-template for more information
using LockAlgorithm;

namespace LockAlgorithm
{
    public class Program
    {
        public static void Main(params string[] args)
        {
            IEnumerable<LockRule> rules = new List<LockRule>()
                {
                    new LockRule(690, 1,    true),
                    new LockRule(741, 1,    false),
                    new LockRule(504, 2,    false),
                    new LockRule(387, 0,    false),
                    new LockRule(219, 1,    false)

                };


            for (int i = 0; i < 1000; i++)
            {
                if (rules.All(q => q.IsValid(i)))
                    Console.WriteLine(i);
            }
        }
    }

    public class LockRule
    {
        private readonly int _correctCount;
        private readonly bool _isCorrectPlace;
        private readonly int[]  _digits;
        public LockRule(int number, int correctCount, bool isCorrectPlace)
        {
            _correctCount = correctCount;
            _isCorrectPlace = isCorrectPlace;
            _digits = GetDigits(number);
        }

        private int[] GetDigits(int number)
        {
            var digits = new int[3];
            digits[0] = number / 100;
            number = number - digits[0] * 100;
            digits[1] = number / 10;
            number = number - digits[1] * 10;
            digits[2] = number;
            return digits;
        }

        public bool IsValid(int number)
        {
            var compareDigits = GetDigits(number);

            if (_isCorrectPlace)
            {
                int sameCount = 0;
                for (int i = 0; i < compareDigits.Length; i++)
                {
                    if (_digits[i] == compareDigits[i])
                        sameCount += 1;
                }
                return sameCount == _correctCount;
            }
            else
            {
                for (int i = 0; i < compareDigits.Length; i++)
                {
                    if (_digits[i] == compareDigits[i])
                        return false;
                }
                int sameCount = 0;
                for (int i = 0; i < compareDigits.Length; i++)
                {
                    for (int j = 0; j < compareDigits.Length; j++)
                    {
                        if ((i != j) && (_digits[i] == compareDigits[j]))
                        {
                            sameCount += 1;
                        }
                    }
                }
                return sameCount == _correctCount;
            }
        }
    }
}



