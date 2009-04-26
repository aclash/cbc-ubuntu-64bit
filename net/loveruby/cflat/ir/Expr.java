package net.loveruby.cflat.ir;
import net.loveruby.cflat.type.Type;
import net.loveruby.cflat.asm.*;

abstract public class Expr {
    protected Type type;

    protected Expr(Type type) {
        this.type = type;
    }

    public Type type() { return type; }

    public boolean isConstant() {
        return false;
    }

    public ImmediateValue asmValue() {
        throw new Error("Expr#asmValue called");
    }

    public boolean isConstantAddress() {
        return false;
    }

    public AsmOperand address() {
        throw new Error("Expr#address called");
    }

    public MemoryReference memref() {
        throw new Error("Expr#memref called");
    }

    abstract public <S,E> E accept(IRVisitor<S,E> visitor);
}
