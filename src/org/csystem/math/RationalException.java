package org.csystem.math;

public class RationalException extends NumberFormatException {
    private RationalExceptionStatus m_rationalExceptionStatus;

    public RationalException(String msg, RationalExceptionStatus rationalExceptionStatus)
    {
        super(msg);
        m_rationalExceptionStatus = rationalExceptionStatus;
    }

    public RationalExceptionStatus getRationalExceptionStatus() {return m_rationalExceptionStatus;}

    public String getMessage()
    {
        return String.format("Message:%s, Status:%s", super.getMessage(), m_rationalExceptionStatus);
    }
}
