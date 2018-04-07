(load "sqrt.scm")

(define (even? n)
  (= (remainder n 2) 0))

(define (double x) (+ x x))
(define (halve x) (/ x 2))
(define (* a b)
  (cond ((= b 0) 0)
        ((even? b) (double (* a (halve b))))
        (else (+ a (double (* a (halve (- b 1))))))
        ))

(* 3 1)
(* 3 2)
(* 3 3)
(* 3 4)

(define (fast-expt-iter b n a)          ; a * b^n
  (cond ((= n 0) a)
        ((even? n) (fast-expt-iter (square b) (/ n 2) a))
        (else (fast-expt-iter b (- n 1) (* b a)))))
(define (fast-expt b n)
  (fast-expt-iter b n 1))

(fast-expt 3 3)
(fast-expt 3 2)
(fast-expt 3 1)
(fast-expt 3 0)
