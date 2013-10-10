package asdf;

/**
 * �ړ��֐���\���C���^�t�F�[�X
 */
public interface EstimationFunction {
    /**
     * ����t�ɂ�����x���W��Ԃ����\�b�h
     * @return ���߂�x���W
     * @param t ���� t
     */
    double getEstimatedX(double t);
    
    /**
     * ����t�ɂ�����y���W��Ԃ����\�b�h
     * @return ���߂�y���W
     * @param t ���� t
     */
    double getEstimatedY(double t);

    /**
     * ���̈ړ��֐��̖��O��Ԃ����\�b�h
     * @return �ړ��֐���
     */
    String getName();
}
